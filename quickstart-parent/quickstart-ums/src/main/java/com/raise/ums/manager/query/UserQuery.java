package com.raise.ums.manager.query;

import com.raise.core.query.Query;


public class UserQuery extends Query {

    public UserQuery withNameEqual(String name) {
        getFirstCriteria().andEqual(UserProperty.name, name);
        return this;
    }

    public UserQuery withNameLike(String name) {
        getFirstCriteria().andLike(UserProperty.name, name);
        return this;
    }

    public UserQuery withAccountEqual(String account) {
        getFirstCriteria().andEqual(UserProperty.account, account);
        return this;
    }

    public UserQuery withEmailEqual(String email) {
        getFirstCriteria().andEqual(UserProperty.email, email);
        return this;
    }

}
