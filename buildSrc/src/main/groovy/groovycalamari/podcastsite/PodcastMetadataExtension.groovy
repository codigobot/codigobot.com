/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020 Sergio del Amo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package groovycalamari.podcastsite

import groovy.transform.CompileStatic
import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Optional

@CompileStatic
class PodcastMetadataExtension {

    final DirectoryProperty outputDirectory

    final RegularFileProperty template

    final RegularFileProperty episodeTemplate

    final Property<String> artwork

    final Property<String> rss

    final Property<String> twitter

    final Property<String> spotify

    final Property<String> applePodcasts

    final Property<String> pocketCasts

    final Property<String> radioPublic

    final Property<String> iTunesId

    final Property<Integer> buttonWidth

    PodcastMetadataExtension(Project project) {
        template = project.objects.fileProperty()
        episodeTemplate = project.objects.fileProperty()
        outputDirectory = project.objects.directoryProperty()
                .convention(project.layout.buildDirectory.dir("podcast"))
        rss = project.objects.property(String)
        artwork = project.objects.property(String)
        twitter = project.objects.property(String).convention('')
        spotify = project.objects.property(String).convention('')
        applePodcasts = project.objects.property(String).convention('')
        pocketCasts = project.objects.property(String).convention('')
        radioPublic = project.objects.property(String).convention('')
        iTunesId = project.objects.property(String)
        buttonWidth = project.objects.property(Integer).convention(70)
    }
}