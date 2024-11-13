package cn.jx.jjvu.ssm.domain;

import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.domain.entity.Sys_Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    private Integer  id;
    private Integer[]  integerArray;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer[] getIntegerArray() {
        return integerArray;
    }

    public void setIntegerArray(Integer[] integerArray) {
        this.integerArray = integerArray;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "id=" + id +
                ", integerArray=" + Arrays.toString(integerArray) +
                '}';
    }
}
