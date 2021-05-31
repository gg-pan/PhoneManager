package pers.gg.yh.manager.common.service;

import pers.gg.yh.manager.common.entity.BaseMainEntity;

import java.time.LocalDateTime;

public abstract class AbstractService {
    public void setBaseMainEntityField(BaseMainEntity entity, String module) {
        entity.setLatest(true);
        entity.setCreatedOn(LocalDateTime.now());
        entity.setUpdatedOn(LocalDateTime.now());
        entity.setVersion(1);
    }

    public String findRefNoByModule(String module) {
        return null;
    }
}
