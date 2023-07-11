package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.MemorandumEntity;
import com.ysnn.api.mapper.MemorandumEntityMapper;
import com.ysnn.api.service.MemorandumService;
import com.ysnn.api.vo.MemorandumVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemorandumServiceImpl extends ServiceImpl<MemorandumEntityMapper, MemorandumEntity> implements MemorandumService {
    @Autowired
    private MemorandumEntityMapper memorandumEntityMapper;
    @Override
    public R getMemorandumEntityData(MemorandumVo memorandumVo){
        MemorandumEntity memorandumEntity = new MemorandumEntity();
        BeanUtils.copyProperties(memorandumVo,memorandumEntity);
        QueryWrapper<MemorandumEntity> judgeQueryWrapper = new QueryWrapper<>();
        judgeQueryWrapper.eq("date",memorandumEntity.getDate());
        judgeQueryWrapper.eq("uid",memorandumEntity.getUid());
        if (memorandumEntityMapper.selectCount(judgeQueryWrapper)>0){
            memorandumEntityMapper.update(memorandumEntity,judgeQueryWrapper);
            return showMemorandumEntityData("update",memorandumEntity);
        }else {
            QueryWrapper<MemorandumEntity> getDateMemTextWrapper = new QueryWrapper<>();
            getDateMemTextWrapper.eq("uid",memorandumEntity.getUid());
            getDateMemTextWrapper.lt("date",memorandumEntity.getDate());
            getDateMemTextWrapper.orderByDesc("date");
            getDateMemTextWrapper.last("LIMIT 1");
            MemorandumEntity result = memorandumEntityMapper.selectOne(getDateMemTextWrapper);
            String needHandle = result.getText();
            String[] needHandleGroups = needHandle.split("\\#\\$\\#;");
            List<String[]>  needHandleGroupsResult = new ArrayList<>();
            for (String needHandleGroup : needHandleGroups ){
                String[] parts = needHandleGroup.split("\\#\\$\\#:");
                needHandleGroupsResult.add(parts);
            }
            StringBuilder handling =new StringBuilder();
            for (int i= 0,j=0; i < needHandleGroupsResult.size();i++){
                if (needHandleGroupsResult.get(i)[1].equals("0")){
                    handling.append(j).append("#$#:");
                    handling.append(needHandleGroupsResult.get(i)[1]).append("#$#:");
                    handling.append(needHandleGroupsResult.get(i)[2]).append("#$#;");
                }
            }
            String handled = handling.toString();
            memorandumEntity.setText(handled);
            memorandumEntityMapper.insert(memorandumEntity);
            return showMemorandumEntityData("Insert",memorandumEntity);
        }
    }
    @Override
    public R showMemorandumEntityData(String mes,MemorandumEntity memorandumEntity){
        QueryWrapper<MemorandumEntity> showQueryWrapper = new QueryWrapper<>();
        showQueryWrapper.eq("uid",memorandumEntity.getUid());
        showQueryWrapper.eq("date",memorandumEntity.getDate());
        return R.success(mes,memorandumEntityMapper.selectList(showQueryWrapper));
    }
    @Override
    public R justShowMemorandumEntityData(int uid,String date){
        MemorandumEntity memorandumEntity = new MemorandumEntity();
        QueryWrapper<MemorandumEntity> judgeQueryWrapper = new QueryWrapper<>();
        judgeQueryWrapper.eq("uid",uid);
        judgeQueryWrapper.eq("date",date);
        if (memorandumEntityMapper.selectCount(judgeQueryWrapper)>0){
            return R.success("success",memorandumEntityMapper.selectList(judgeQueryWrapper));
        }else {
            return R.error("null or error");
        }
    }

}
