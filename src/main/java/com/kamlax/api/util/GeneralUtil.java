/**
 *
 */
package com.kamlax.api.util;


import com.kamlax.api.constants.Constants;

/**
 * @author Rashedul.Hasan.Khan
 *
 */
public class GeneralUtil {

    /**
     * Checks if one String is empty or not
     *
     * @param value
     * @return boolean
     */
    public static boolean isEmpty(String value) {
        if ((value == null) || ("".equals(value))
                || (value.equals(Constants.HTML_SELECT_NULL_STRING))
                || (value.equals(Constants.HTML_SELECT_UNDEFINED_STRING))) {
            return true;
        } else {
            return false;
        }
    }
}
