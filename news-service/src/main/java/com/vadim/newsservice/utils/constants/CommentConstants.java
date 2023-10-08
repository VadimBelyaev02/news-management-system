package com.vadim.newsservice.utils.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommentConstants {

    public final static String COMMENT_API_PATH = "/api/comments";

    public final static String COMMENT_NOT_FOUND_BY_ID = "Comment with id = %s is not found";

    private final static String ABSENCE_OF_ACCESS = "You don't have access to ";

    public final static String NO_ACCESS_TO_UPDATE_COMMENT = ABSENCE_OF_ACCESS + "update comment with id = %s";

    public final static String NO_ACCESS_TO_DELETE_COMMENT = ABSENCE_OF_ACCESS + "delete comment with id = %s";

    public final static String NO_ACCESS_TO_CREATE_COMMENT = ABSENCE_OF_ACCESS + "create a comment";


}
