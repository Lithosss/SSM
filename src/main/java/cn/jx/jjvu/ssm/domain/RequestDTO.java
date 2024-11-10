package cn.jx.jjvu.ssm.domain;

import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.domain.entity.Sys_Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private Sys_Role sysRole;
    private Sys_Per sysPer;
    private Integer  id;
    private Integer[]  integerArray;

}
