package com.imcaojie.pojo.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author caojie
 * @className AccountUpdateBO
 * @description
 **/
@Data
public class AccountUpdateBO {

    @NotNull
    @Min(value = 1,message = "账户ID错误")
    @ApiModelProperty(value = "用户名",name = "id",example = "1",required = true)
    private Long id;

    @Length(max = 12, message = "用户名不能超过12位")
    @ApiModelProperty(value = "用户名",name = "name",example = "caojie",required = false)
    private String name;

    @ApiModelProperty(value = "电话号码",name = "phone",example = "13112345678",required = false)
    private Integer phone;
}
