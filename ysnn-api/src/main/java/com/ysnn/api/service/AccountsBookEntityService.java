package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.AccountsBookEntity;
import com.ysnn.api.vo.AccountBooksVo;

public interface AccountsBookEntityService extends IService<AccountsBookEntity> {
    R getAcountsData(AccountBooksVo accountBooksVo);
    R showAccountsData (String mes, AccountsBookEntity accountsBookEntity);
    R justShowData(int uid,String data);
}
