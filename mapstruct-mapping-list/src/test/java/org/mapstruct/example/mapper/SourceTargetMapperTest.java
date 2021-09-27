/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.mapper;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;
import org.mapstruct.example.bean.IdentityContext;
import org.mapstruct.example.bean.SourceDO;
import org.mapstruct.example.bean.TargetDTO;

/**
 *
 * @author junlei.shan
 */
public class SourceTargetMapperTest {

    /**
     * Test if everything is working when sources are present
     */
    @Test
    public void testListWithId() {

        SourceDO s = new SourceDO();
        s.setName("Shan");
        List<SourceDO> sourceDOS = new ArrayList<>();
        sourceDOS.add(s);

        TargetDTO t = new TargetDTO();
        List<TargetDTO>  targetDTOS = new ArrayList<>();
        targetDTOS.add(t);

        // its a  context
        List<TargetDTO> mammalEntity = SourceTargetMapper.MAPPER.convert(sourceDOS,3L);

        assertThat( mammalEntity.get(0).getName() ).isEqualTo( "Shan" );
        assertThat( mammalEntity.get(0).getId() ).isEqualTo( 3L );

    }

    /**
     * Test if everything is working when sources are present
     */
    @Test
    public void testListContext() {

        SourceDO s = new SourceDO();
        s.setName("Shan");
        List<SourceDO> sourceDOS = new ArrayList<>();
        sourceDOS.add(s);

        TargetDTO t = new TargetDTO();
        List<TargetDTO>  targetDTOS = new ArrayList<>();
        targetDTOS.add(t);

        List<TargetDTO> mammalEntity = SourceTargetMapper.MAPPER.convert(sourceDOS,new IdentityContext(3L));

        assertThat( mammalEntity.get(0).getName() ).isEqualTo( "Shan" );
        assertThat( mammalEntity.get(0).getId() ).isEqualTo( 3L );

    }


}
