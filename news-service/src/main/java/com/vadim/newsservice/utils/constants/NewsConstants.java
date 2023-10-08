package com.vadim.newsservice.utils.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NewsConstants {

    public final static String NEWS_API_PATH = "/api/news";

    public final static String NEWS_NOT_FOUND_BY_ID = "News with id = %s is not found";

    private final static String ABSENCE_OF_ACCESS = "You don't have access to ";

    public final static String NO_ACCESS_TO_UPDATE_NEWS = ABSENCE_OF_ACCESS + "update news with id = %s";

    public final static String NO_ACCESS_TO_DELETE_NEWS = ABSENCE_OF_ACCESS + "delete news with id = %s";

    public final static String NO_ACCESS_TO_CREATE_NEWS = ABSENCE_OF_ACCESS + "create a news";
}
