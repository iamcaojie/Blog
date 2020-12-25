package com.imcaojie.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author caojie
 * @className AccountBo
 * @description
 **/
@Data
public class AccountCreateBO {

    @NotNull
    @NotEmpty
    @NotBlank(message = "用户名不能为空")
    @Length(max = 12, message = "用户名不能超过12位")
    @ApiModelProperty(value = "用户名",name = "name",example = "caojie",required = false)
    private String name;

    @NotNull
    @NotEmpty
    @Min(value = 1,message = "电话号码错误")
    @Max(value = 2,message = "电话号码错误")
    @ApiModelProperty(value = "电话号码",name = "phone",example = "13112345678",required = false)
    private Integer phone;

}
