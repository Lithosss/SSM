package cn.jx.jjvu.ssm.domain.VO;

import cn.jx.jjvu.ssm.domain.LoginUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserVO {

    private LoginUser user;
    private String token;

}
