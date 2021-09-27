/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.mapper;


import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.example.bean.IdentityContext;
import org.mapstruct.example.bean.SourceDO;
import org.mapstruct.example.bean.TargetDTO;
import org.mapstruct.factory.Mappers;

/**
 * @author junlei.shan
 */
@Mapper
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    // ----- first

    /**
     * Use Context annotation and expression  set id
     *
     * @param sourceDO
     * @param id
     * @return
     */
    @Mapping( target = "id", expression = "java(id)")
    TargetDTO convert(SourceDO sourceDO, @Context Long id);

    /**
     * convert source list to target list
     *
     * @param sourceDO
     * @param id
     * @return
     */
    List<TargetDTO>  convert(List<SourceDO> sourceDO, @Context Long id);

    // ----- first end


    // second
    /**
     * Use Context AfterMapping annotations set id
     * first ignore id true
     *
     * @param sourceDO
     * @param context
     * @return
     */
    @Mapping( target = "id", ignore = true)
    TargetDTO convert(SourceDO sourceDO, @Context IdentityContext context);

    /**
     * convert source list to target list
     *
     * @param sourceDO
     * @param context
     * @return
     */

    List<TargetDTO>  convert(List<SourceDO> sourceDO, @Context IdentityContext context);
    // second end
}
