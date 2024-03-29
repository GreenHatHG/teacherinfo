package team.weacsoft.teacherinfo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author GreenHatHG
 */

@Data
@AllArgsConstructor
public class ErrorResponseEntity {

    private int code;
    private String message;

}