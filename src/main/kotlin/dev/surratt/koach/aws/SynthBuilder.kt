package dev.surratt.koach.aws

import software.amazon.awssdk.services.polly.model.VoiceId
import java.io.File

fun polly(): SynthBuilder {
    return SynthBuilder()
}

class SynthBuilder {

    private lateinit var voiceId: VoiceId
    private lateinit var ssmlText: String
    private lateinit var targetFile: File

    fun synthesize(text: String): SynthBuilder {
        ssmlText = text
        return this
    }

    fun withVoice(voice: VoiceId): SynthBuilder {
        voiceId = voice
        return this
    }

    fun toFile(file: File) {
        targetFile = file
        PollySynth(voiceId).generate(ssmlText, targetFile)
    }

}
