<template>
  <div>
    <button @click="initCamera">Start Camera</button>
    <button @click="take_snapshot">Take Snapshot</button>
    <button @click="stopCamera">Stop Camera</button>
    <video id="video" autoplay playsinline width="320" height="240"></video>
    <canvas id="canvas" width="320" height="240"></canvas>

  </div>
</template>

<script>

export default {
    data() {
        return {
            resultSource: '',
            videoStream: null
        }
    },
    methods: {
        initCamera() {
            navigator.mediaDevices.getUserMedia({ video: true, audio: false }).then(stream => {
                const video = document.querySelector("#video");
                this.videoStream = stream;
                video.srcObject = stream;
            });

        },
        stopCamera() {
            this.videoStream.getTracks().forEach( (track) => {
                track.stop();
            });
        },
        take_snapshot() {
            const video = document.querySelector("#video");
            const canvas = document.querySelector("#canvas");
            canvas.getContext('2d').drawImage(video, 0, 0, canvas.width, canvas.height);
            const image_data_url = canvas.toDataURL('image/jpeg');

            console.log(image_data_url);
		}
    },
    created() {
    }

}
</script>

<style>

</style>