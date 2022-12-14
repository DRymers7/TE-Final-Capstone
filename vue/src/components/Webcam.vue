<template>
  <div id="camcapture">
    <div class="command">
      <button @click="initCamera">Start Camera</button>
      <button @click="take_snapshot">Take Snapshot</button>
      <button @click="stopCamera">Stop Camera</button>
      <button @click="postNewImage">Use For Profile</button>
    </div>
    <div class="vid">
      <video
        id="video"
        ref="video"
        :srcObject.prop="videoStream"
        autoplay
        playsinline
        width="320"
        height="240"
      ></video>
      <canvas id="canvas" ref="canvas" width="320" height="240"></canvas>
    </div>
  </div>
</template>

<script>
import WebcamService from "../services/WebcamService";

export default {
  data() {
    return {
      videoStream: null,
      imageData: null,
    };
  },
  methods: {
    initCamera() {
      navigator.mediaDevices
        .getUserMedia({ video: true, audio: false })
        .then((stream) => {
          this.videoStream = stream;
        });
    },
    stopCamera() {
      this.videoStream.getTracks().forEach((track) => {
        track.stop();
      });
    },
    take_snapshot() {
      this.$refs.canvas
        .getContext("2d")
        .drawImage(
          this.$refs.video,
          0,
          0,
          this.$refs.canvas.width,
          this.$refs.canvas.height
        );
      this.imageData = this.$refs.canvas.toDataURL("image/jpeg");

      console.log(this.imageData);
    },
    postNewImage() {
      WebcamService.postNewImage(this.imageData)
        .then((response) => {
          if (response.status == 200) {
            this.resetForm();
          }
        })
        .catch((error) => console.error(error));
    },
  },
};
</script>

<style>
div#camcapture div.command button {
  margin: 10px;
  width: 22%;
  height: 40px;
  font-size: 1.2rem;
  border-radius: 20px;
  border: 2px solid rgb(44, 44, 44);
  color: gray;
  background-color: aliceblue;
}

div#camcapture div.command button:hover {
  cursor: pointer;
  background-color: lightgrey;
  border: 3px solid rgb(2, 2, 63);
  filter: drop-shadow(0 0.25rem 0.25rem rgb(0, 0, 0));
}

div#camcapture div.vid {
  margin-top: 50px;
}

div#camcapture div.vid video,
div#camcapture div.vid canvas {
  padding: 10px;
  border: 2px solid black;
  border-radius: 5px;
}

div#camcapture canvas#canvas {
  margin-left: 50px;
}
</style>
