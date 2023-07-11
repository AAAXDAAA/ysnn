package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.AccountsBookEntity;
import com.ysnn.api.entity.DiaryEntity;
import com.ysnn.api.mapper.AccoutsbookEntityMapper;
import com.ysnn.api.service.AccountsBookEntityService;
import com.ysnn.api.vo.AccountBooksVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccountsBookEntityServiceImpl extends ServiceImpl<AccoutsbookEntityMapper, AccountsBookEntity> implements AccountsBookEntityService {
    @Autowired
    private AccoutsbookEntityMapper accoutsbookEntityMapper;
    @Override
    public R getAcountsData(AccountBooksVo accountBooksVo){
            AccountsBookEntity accountsBookEntity = new AccountsBookEntity();
            BeanUtils.copyProperties(accountBooksVo,accountsBookEntity);
            QueryWrapper<AccountsBookEntity> judgeWrapper = new QueryWrapper<>();
            judgeWrapper.eq("uid",accountsBookEntity.getUid()) ;
            judgeWrapper.eq("date",accountsBookEntity.getDate());
            if (accoutsbookEntityMapper.selectCount(judgeWrapper)>0){
                accoutsbookEntityMapper.update(accountsBookEntity,judgeWrapper);
                return showAccountsData("update",accountsBookEntity);
            }else {

            QueryWrapper<AccountsBookEntity> getDateWrapper = new QueryWrapper<>();
            getDateWrapper.eq("uid",accountsBookEntity.getUid());
            getDateWrapper.lt("date",accountsBookEntity.getDate());
            getDateWrapper.orderByDesc("date");
            getDateWrapper.last("LIMIT 1");
            AccountsBookEntity getDateWrapperResult = accoutsbookEntityMapper.selectOne(getDateWrapper);
            if (accoutsbookEntityMapper.selectCount(getDateWrapper)>0) {
                LocalDate localDate = LocalDate.parse(getDateWrapperResult.getDate());
                int month = localDate.getMonthValue();
                LocalDate VoLocalDate = LocalDate.parse(accountBooksVo.getDate());
                int VoMonth = VoLocalDate.getMonthValue();
                if ((VoMonth - month) > 0) {
                    accoutsbookEntityMapper.insert(accountsBookEntity);
                    return showAccountsData("monthUpdateInsert", accountsBookEntity);
                } else {
                    float mic = getDateWrapperResult.getMouthincome();
                    float mp = getDateWrapperResult.getMouthpay();
                    float mt = getDateWrapperResult.getMouthtatol();
                    accountsBookEntity.setMouthincome(mic);
                    accountsBookEntity.setMouthpay(mp);
                    accountsBookEntity.setMouthtatol(mt);
                    accoutsbookEntityMapper.insert(accountsBookEntity);
                    return showAccountsData("Insert", accountsBookEntity);
                }
            }else {
                accoutsbookEntityMapper.insert(accountsBookEntity);
                return showAccountsData("zeroInsert", accountsBookEntity);
            }
        }
    }
    @Override
    public  R showAccountsData (String mes, AccountsBookEntity accountsBookEntity){
        QueryWrapper<AccountsBookEntity> showQuerywapper = new QueryWrapper<>();
        showQuerywapper.eq("uid",accountsBookEntity.getUid());
        showQuerywapper.eq("date",accountsBookEntity.getDate());
        return R.success(mes,accoutsbookEntityMapper.selectList(showQuerywapper));
    }


    @Override
    public  R justShowData(int uid,String date){
        AccountsBookEntity accountsBookEntity = new AccountsBookEntity();
        QueryWrapper<AccountsBookEntity> justShowDateQueryWrapper = new QueryWrapper<>();
        justShowDateQueryWrapper.eq("uid",uid);
        justShowDateQueryWrapper.eq("date",date);
        if (accoutsbookEntityMapper.selectCount(justShowDateQueryWrapper)>0){
            return R.success("success",accoutsbookEntityMapper.selectList(justShowDateQueryWrapper));
        }else {
            return R.error("null or error");
        }
    }


}
