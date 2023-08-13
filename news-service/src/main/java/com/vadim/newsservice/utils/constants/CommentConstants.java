package com.vadim.newsservice.utils.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommentConstants {

    public final static String COMMENT_API_PATH = "/api/comments";

    public final static String COMMENT_NOT_FOUND_BY_ID = "Comment with id = %s is not found";

    public final static String NO_ACCESS_TO_UPDATE_COMMENT = "You don't have access to update comment with id = %s";

    public final static String NO_ACCESS_TO_DELETE_COMMENT = "You don't have access to delete comment with id = %s";

    public final static String NO_ACCESS_TO_CREATE_COMMENT = "You don't have access to create a comment";


}
