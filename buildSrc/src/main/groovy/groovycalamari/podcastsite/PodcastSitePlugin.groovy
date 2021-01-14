package groovycalamari.podcastsite

import groovy.transform.CompileStatic
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.plugins.BasePlugin

@CompileStatic
class PodcastSitePlugin implements Plugin<Project> {
    public static final String EXTENSION_NAME_BUILDINFO = "podcastMetadata"
    public static final String TASK_BUILD = "build"
    public static final String TASK_BUILD_PODCAST_SITE = "buildPodcastSite"
    public static final String GROUP_BUILD = "build"
    public static final String DESCRIPTION = "Generates a static site for a rss feed"

    @Override
    void apply(Project project) {
        project.getPlugins().apply(BasePlugin.class)

        PodcastMetadataExtension extension = project.extensions.create(EXTENSION_NAME_BUILDINFO, PodcastMetadataExtension, project)

        def buildInfoTask = project.tasks.register(TASK_BUILD_PODCAST_SITE, PodcastSiteTask, new Action<PodcastSiteTask>() {
            @Override
            void execute(PodcastSiteTask task) {
                task.setGroup(GROUP_BUILD)
                task.setDescription(DESCRIPTION)
                task.template.convention(extension.template)
                task.episodeTemplate.convention(extension.episodeTemplate)
                task.subscribeTemplate.convention(extension.subscribeTemplate)
                task.outputDirectory.convention(extension.outputDirectory)
                task.twitter.convention(extension.twitter)
                task.rss.convention(extension.rss)
                task.artwork.convention(extension.artwork)
                task.buttonWidth.convention(extension.buttonWidth)
                task.applePodcasts.convention(extension.applePodcasts)
                task.radioPublic.convention(extension.radioPublic)
                task.iTunesId.convention(extension.iTunesId)
                task.spotify.convention(extension.spotify)
            }
        })

        project.tasks.named(TASK_BUILD).configure(new Action<Task>() {
            @Override
            void execute(Task task) {
                task.dependsOn(TASK_BUILD_PODCAST_SITE)
            }
        })

    }
}
