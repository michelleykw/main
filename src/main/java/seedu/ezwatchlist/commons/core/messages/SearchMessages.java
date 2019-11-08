package seedu.ezwatchlist.commons.core.messages;

/**
 * Container for user visible messages when executing the search command.
 */
public class SearchMessages {
    public static final String MESSAGE_USAGE =
            "Search : Searches for shows whose names contain any of the given keywords from the watchlist, "
            + "watched list and online.\n"
            + "- by name: search n/SHOW_NAME… [g/GENRE]… [a/ACTOR_NAME]… [o/FROM_ONLINE] [t/TYPE] [w/HAS_WATCHED]\n"
            + "- by genre: search g/GENRE… [n/SHOW_NAME]… [a/ACTOR_NAME]… [o/FROM_ONLINE] [t/TYPE] [w/HAS_WATCHED]\n"
            + "- by actor (from watchlist): search a/ACTOR_NAME… [n/SHOW_NAME]… [g/GENRE]… [t/TYPE] [w/HAS_WATCHED]\n"
            + "Enter 'help' command for more detailed examples.";

    public static final String MESSAGE_SHOWS_FOUND_OVERVIEW = "%1$d shows found!";

    public static final String MESSAGE_INTERNAL_SHOW_LISTED_OVERVIEW = "You are offline. "
            + "Shows are searched from watchlist and watched list only, even if you requested to search from online.\n"
            + MESSAGE_SHOWS_FOUND_OVERVIEW;

    public static final String MESSAGE_INVALID_FROM_ONLINE_COMMAND =
            "Invalid input. For o/[OPTION], OPTION has to be either true/yes or false/no";
    public static final String MESSAGE_INVALID_IS_WATCHED_COMMAND =
            "Invalid input. For w/[IS_WATCHED], IS_WATCHED has to be either true/yes or false/no";
    public static final String MESSAGE_UNABLE_TO_SEARCH_FROM_ONLINE_WHEN_SEARCHING_BY_ACTOR =
            "Invalid input. When searching by actor, it is not possible to search from online.\n" + MESSAGE_USAGE;

    public static final String MESSAGE_INVALID_TYPE_COMMAND =
            "Invalid type. t/[TYPE] where TYPE is either movie or tv";
    public static final String MESSAGE_INVALID_GENRE_COMMAND = "Invalid input. Ensure that genre is not empty.\n"
            + "search g/GENRE… [n/SHOW_NAME]… [a/ACTOR_NAME]… [i/IS_INTERNAL] [t/TYPE] [w/IS_WATCH]";
}