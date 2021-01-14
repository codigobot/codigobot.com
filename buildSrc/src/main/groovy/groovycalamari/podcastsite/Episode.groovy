package groovycalamari.podcastsite

import groovy.transform.CompileStatic
import groovy.transform.ToString

@CompileStatic
@ToString(excludes = 'description')
class Episode {
    String title
    String description
    String url
    String showNotes
    Integer episode
    Integer season
    Date pubDate
    BigDecimal size
}
