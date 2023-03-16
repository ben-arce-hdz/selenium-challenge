
package com.selenium.uiautomation.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    //Error Messages
    public static final String SUMMARY_TABLE_ROWS_COUNT_ERROR_MSG = "Summary table is displaying:%d, expecting:%d";
    public static final String SUMMARY_ACCOUNTS_ERROR_MSG = "Summary Accounts has:%s, expecting:%s";
    public static final String NEW_LOAN_BUTTON_IS_NOT_VISIBLE = "New Loan button is not visible.";
    public static final String REPORTS_ICON_IS_NOT_VISIBLE = "Reports icon is not visible.";
    public static final String USERNAME_INPUT_IS_NOT_VISIBLE = "Username input is not visible.";
    public static final String PASSWORD_INPUT_IS_NOT_VISIBLE = "Password input is not visible.";
    public static final String LOGIN_BUTTON_IS_NOT_VISIBLE = "Login button is not visible.";
    public static final String LOANS_LINK_IS_NOT_VISIBLE = "Loans link is not visible.";
    public static final String USER_IMAGE_IS_NOT_VISIBLE = "User image is not visible.";
    public static final String TITLE_SPAN_IS_NOT_VISIBLE = "Title span is not visible.";

    public static final String IMAGE_PNG = "image/png";
    public static final String DISABLE_GPU = "--disable-gpu";
    public static final String HEADLESS = "--headless";
    public static final String START_MAXIMIZED = "start-maximized";
}