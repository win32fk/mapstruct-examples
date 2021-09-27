package org.mapstruct.example.bean;

import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

/**
 * @author junlei.shan
 */
public class IdentityContext {
    private final Long id;

    public IdentityContext(Long id){
        this.id = id;
    }

    @AfterMapping
    public void setIds(SourceDO sourceDO, @MappingTarget TargetDTO targetDTO) {
        targetDTO.setName(sourceDO.getName());
        targetDTO.setId( id );
    }
}
