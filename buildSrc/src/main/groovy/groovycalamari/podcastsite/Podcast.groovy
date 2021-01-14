package groovycalamari.podcastsite

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString(excludes = ['description'])
@CompileStatic
class Podcast {
    String copyright
    String title
    String link
    String artwork
    String description
    String author
    List<Episode> episodes = []
}
