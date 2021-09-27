package org.mapstruct.example.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.example.bean.IdentityContext;
import org.mapstruct.example.bean.SourceDO;
import org.mapstruct.example.bean.TargetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-27T14:14:11+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
public class SourceTargetMapperImpl implements SourceTargetMapper {

    @Override
    public TargetDTO convert(SourceDO sourceDO, Long id) {
        if ( sourceDO == null ) {
            return null;
        }

        TargetDTO targetDTO = new TargetDTO();

        targetDTO.setName( sourceDO.getName() );

        targetDTO.setId( id );

        return targetDTO;
    }

    @Override
    public List<TargetDTO> convert(List<SourceDO> sourceDO, Long id) {
        if ( sourceDO == null ) {
            return null;
        }

        List<TargetDTO> list = new ArrayList<TargetDTO>( sourceDO.size() );
        for ( SourceDO sourceDO1 : sourceDO ) {
            list.add( convert( sourceDO1, id ) );
        }

        return list;
    }

    @Override
    public TargetDTO convert(SourceDO sourceDO, IdentityContext context) {
        if ( sourceDO == null ) {
            return null;
        }

        TargetDTO targetDTO = new TargetDTO();

        targetDTO.setName( sourceDO.getName() );

        context.setIds( sourceDO, targetDTO );

        return targetDTO;
    }

    @Override
    public List<TargetDTO> convert(List<SourceDO> sourceDO, IdentityContext context) {
        if ( sourceDO == null ) {
            return null;
        }

        List<TargetDTO> list = new ArrayList<TargetDTO>( sourceDO.size() );
        for ( SourceDO sourceDO1 : sourceDO ) {
            list.add( convert( sourceDO1, context ) );
        }

        return list;
    }
}
