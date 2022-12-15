<template>
  <div class="wrapper">
    <div class="left-side">
      <router-link v-bind:to="{ name: 'dashboard' }">
        <svg
          viewBox="0 0 512 512"
          fill="currentColor"
          xmlns="http://www.w3.org/2000/svg"
          class="active"
        >
          <path
            d="M197.3 170.7h-160A37.4 37.4 0 010 133.3v-96A37.4 37.4 0 0137.3 0h160a37.4 37.4 0 0137.4 37.3v96a37.4 37.4 0 01-37.4 37.4zM37.3 32c-3 0-5.3 2.4-5.3 5.3v96c0 3 2.4 5.4 5.3 5.4h160c3 0 5.4-2.4 5.4-5.4v-96c0-3-2.4-5.3-5.4-5.3zm0 0M197.3 512h-160A37.4 37.4 0 010 474.7v-224a37.4 37.4 0 0137.3-37.4h160a37.4 37.4 0 0137.4 37.4v224a37.4 37.4 0 01-37.4 37.3zm-160-266.7c-3 0-5.3 2.4-5.3 5.4v224c0 3 2.4 5.3 5.3 5.3h160c3 0 5.4-2.4 5.4-5.3v-224c0-3-2.4-5.4-5.4-5.4zm0 0M474.7 512h-160a37.4 37.4 0 01-37.4-37.3v-96a37.4 37.4 0 0137.4-37.4h160a37.4 37.4 0 0137.3 37.4v96a37.4 37.4 0 01-37.3 37.3zm-160-138.7c-3 0-5.4 2.4-5.4 5.4v96c0 3 2.4 5.3 5.4 5.3h160c3 0 5.3-2.4 5.3-5.3v-96c0-3-2.4-5.4-5.3-5.4zm0 0M474.7 298.7h-160a37.4 37.4 0 01-37.4-37.4v-224A37.4 37.4 0 01314.7 0h160A37.4 37.4 0 01512 37.3v224a37.4 37.4 0 01-37.3 37.4zM314.7 32c-3 0-5.4 2.4-5.4 5.3v224c0 3 2.4 5.4 5.4 5.4h160c3 0 5.3-2.4 5.3-5.4v-224c0-3-2.4-5.3-5.3-5.3zm0 0"
          />
        </svg>
        <p>Get Dose</p>
      </router-link>
      <router-link v-bind:to="{ name: 'history' }">
        <svg
          viewBox="0 0 24 24"
          fill="none"
          stroke="currentColor"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        >
          <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5" />
        </svg>
        <p>History</p>
      </router-link>
      <router-link v-bind:to="{ name: 'profile' }">
        <svg viewBox="0 1 511 512" fill="currentColor">
          <path
            d="M498.7 222.7L289.8 13.8a46.8 46.8 0 00-66.7 0L14.4 222.6l-.2.2A47.2 47.2 0 0047 303h8.3v153.7a55.2 55.2 0 0055.2 55.2h81.7a15 15 0 0015-15V376.5a25.2 25.2 0 0125.2-25.2h48.2a25.2 25.2 0 0125.1 25.2V497a15 15 0 0015 15h81.8a55.2 55.2 0 0055.1-55.2V303.1h7.7a47.2 47.2 0 0033.4-80.4zm-21.2 45.4a17 17 0 01-12.2 5h-22.7a15 15 0 00-15 15v168.7a25.2 25.2 0 01-25.1 25.2h-66.8V376.5a55.2 55.2 0 00-55.1-55.2h-48.2a55.2 55.2 0 00-55.2 55.2V482h-66.7a25.2 25.2 0 01-25.2-25.2V288.1a15 15 0 00-15-15h-23A17.2 17.2 0 0135.5 244L244.4 35a17 17 0 0124.2 0l208.8 208.8v.1a17.2 17.2 0 010 24.2zm0 0"
          />
        </svg>
        <p>Profile</p>
      </router-link>
      <router-link v-bind:to="{ name: 'settings' }">
        <svg viewBox="0 0 512 512" fill="currentColor">
          <path
            d="M272 512h-32c-26 0-47.2-21.1-47.2-47.1V454c-11-3.5-21.8-8-32.1-13.3l-7.7 7.7a47.1 47.1 0 01-66.7 0l-22.7-22.7a47.1 47.1 0 010-66.7l7.7-7.7c-5.3-10.3-9.8-21-13.3-32.1H47.1c-26 0-47.1-21.1-47.1-47.1v-32.2c0-26 21.1-47.1 47.1-47.1H58c3.5-11 8-21.8 13.3-32.1l-7.7-7.7a47.1 47.1 0 010-66.7l22.7-22.7a47.1 47.1 0 0166.7 0l7.7 7.7c10.3-5.3 21-9.8 32.1-13.3V47.1c0-26 21.1-47.1 47.1-47.1h32.2c26 0 47.1 21.1 47.1 47.1V58c11 3.5 21.8 8 32.1 13.3l7.7-7.7a47.1 47.1 0 0166.7 0l22.7 22.7a47.1 47.1 0 010 66.7l-7.7 7.7c5.3 10.3 9.8 21 13.3 32.1h10.9c26 0 47.1 21.1 47.1 47.1v32.2c0 26-21.1 47.1-47.1 47.1H454c-3.5 11-8 21.8-13.3 32.1l7.7 7.7a47.1 47.1 0 010 66.7l-22.7 22.7a47.1 47.1 0 01-66.7 0l-7.7-7.7c-10.3 5.3-21 9.8-32.1 13.3v10.9c0 26-21.1 47.1-47.1 47.1zM165.8 409.2a176.8 176.8 0 0045.8 19 15 15 0 0111.3 14.5V465c0 9.4 7.7 17.1 17.1 17.1h32.2c9.4 0 17.1-7.7 17.1-17.1v-22.2a15 15 0 0111.3-14.5c16-4.2 31.5-10.6 45.8-19a15 15 0 0118.2 2.3l15.7 15.7a17.1 17.1 0 0024.2 0l22.8-22.8a17.1 17.1 0 000-24.2l-15.7-15.7a15 15 0 01-2.3-18.2 176.8 176.8 0 0019-45.8 15 15 0 0114.5-11.3H465c9.4 0 17.1-7.7 17.1-17.1v-32.2c0-9.4-7.7-17.1-17.1-17.1h-22.2a15 15 0 01-14.5-11.2c-4.2-16.1-10.6-31.6-19-45.9a15 15 0 012.3-18.2l15.7-15.7a17.1 17.1 0 000-24.2l-22.8-22.8a17.1 17.1 0 00-24.2 0l-15.7 15.7a15 15 0 01-18.2 2.3 176.8 176.8 0 00-45.8-19 15 15 0 01-11.3-14.5V47c0-9.4-7.7-17.1-17.1-17.1h-32.2c-9.4 0-17.1 7.7-17.1 17.1v22.2a15 15 0 01-11.3 14.5c-16 4.2-31.5 10.6-45.8 19a15 15 0 01-18.2-2.3l-15.7-15.7a17.1 17.1 0 00-24.2 0l-22.8 22.8a17.1 17.1 0 000 24.2l15.7 15.7a15 15 0 012.3 18.2 176.8 176.8 0 00-19 45.8 15 15 0 01-14.5 11.3H47c-9.4 0-17.1 7.7-17.1 17.1v32.2c0 9.4 7.7 17.1 17.1 17.1h22.2a15 15 0 0114.5 11.3c4.2 16 10.6 31.5 19 45.8a15 15 0 01-2.3 18.2l-15.7 15.7a17.1 17.1 0 000 24.2l22.8 22.8a17.1 17.1 0 0024.2 0l15.7-15.7a15 15 0 0118.2-2.3z"
          />
          <path
            d="M256 367.4c-61.4 0-111.4-50-111.4-111.4s50-111.4 111.4-111.4 111.4 50 111.4 111.4-50 111.4-111.4 111.4zm0-192.8a81.5 81.5 0 000 162.8 81.5 81.5 0 000-162.8z"
          />
        </svg>
        <p>Settings</p>
      </router-link>
      <router-link v-bind:to="{ name: 'logout' }">
        <svg viewBox="0 0 512 512" fill="currentColor">
          <path
            d="M255.2 468.6H63.8a21.3 21.3 0 01-21.3-21.2V64.6c0-11.7 9.6-21.2 21.3-21.2h191.4a21.2 21.2 0 100-42.5H63.8A63.9 63.9 0 000 64.6v382.8A63.9 63.9 0 0063.8 511H255a21.2 21.2 0 100-42.5z"
          />
          <path
            d="M505.7 240.9L376.4 113.3a21.3 21.3 0 10-29.9 30.3l92.4 91.1H191.4a21.2 21.2 0 100 42.6h247.5l-92.4 91.1a21.3 21.3 0 1029.9 30.3l129.3-127.6a21.3 21.3 0 000-30.2z"
          />
        </svg>
        <p>Logout</p>
      </router-link>
    </div>
    <div class="main-container">
      <div class="header">
        <div class="logo">Insulin Hero <span class="logo-det">I H</span></div>
        <div class="user-info">
          <div class="user-name">User</div>
          <svg class="profile" viewBox="-42 0 512 512" fill="currentColor">
            <path
              d="M210.4 246.6c33.8 0 63.2-12.1 87.1-36.1 24-24 36.2-53.3 36.2-87.2 0-33.9-12.2-63.2-36.2-87.2-24-24-53.3-36.1-87.1-36.1-34 0-63.3 12.2-87.2 36.1S87 89.4 87 123.3c0 33.9 12.2 63.2 36.2 87.2 24 24 53.3 36.1 87.2 36.1zm-66-189.3a89.1 89.1 0 0166-27.3c26 0 47.5 9 66 27.3a89.2 89.2 0 0127.3 66c0 26-9 47.6-27.4 66a89.1 89.1 0 01-66 27.3c-26 0-47.5-9-66-27.3a89.1 89.1 0 01-27.3-66c0-26 9-47.6 27.4-66zm0 0M426.1 393.7a304.6 304.6 0 00-12-64.9 160.7 160.7 0 00-13.5-30.3c-5.7-10.2-12.5-19-20.1-26.3a88.9 88.9 0 00-29-18.2 100.1 100.1 0 00-37-6.7c-5.2 0-10.2 2.2-20 8.5-6 4-13 8.5-20.9 13.5-6.7 4.3-15.8 8.3-27 11.9a107.3 107.3 0 01-66 0 119.3 119.3 0 01-27-12l-21-13.4c-9.7-6.3-14.8-8.5-20-8.5a100 100 0 00-37 6.7 88.8 88.8 0 00-29 18.2 114.4 114.4 0 00-20.1 26.3 161 161 0 00-13.4 30.3A302.5 302.5 0 001 393.7c-.7 9.8-1 20-1 30.2 0 26.8 8.5 48.4 25.3 64.4C41.8 504 63.6 512 90.3 512h246.5c26.7 0 48.6-8 65.1-23.7 16.8-16 25.3-37.6 25.3-64.4a437 437 0 00-1-30.2zm-44.9 72.8c-11 10.4-25.4 15.5-44.4 15.5H90.3c-19 0-33.4-5-44.4-15.5C35.2 456.3 30 442.4 30 424c0-9.5.3-19 1-28.1A272.9 272.9 0 0141.7 338a131 131 0 0110.9-24.7A84.8 84.8 0 0167.4 294a59 59 0 0119.3-12 69 69 0 0123.6-4.5c1 .5 3 1.6 6 3.6l21 13.6c9 5.6 20.4 10.7 34 15.1a137.3 137.3 0 0084.5 0c13.7-4.4 25.1-9.5 34-15.1a2721 2721 0 0027-17.2 69 69 0 0123.7 4.5 59 59 0 0119.2 12 84.5 84.5 0 0114.9 19.4c4.5 8 8.2 16.3 10.8 24.7a275.2 275.2 0 0110.8 57.8c.6 9 1 18.5 1 28.1 0 18.5-5.3 32.4-16 42.6zm0 0"
            />
          </svg>
        </div>
      </div>
      <div class="user-box first-box">
        <div class="activity card" style="--delay: .2s">
          <div class="title">User Alerts</div>
          <div class="activity-links">
            <div class="activity-link active">Current User</div>
            <div class="activity-link">Emergency Contact</div>
          </div>
        </div>
      </div>
      <div class="user-box second-box">
        <div class="cards-wrapper" style="--delay: 1s">
          <div class="cards-header">
            <div class="cards-view">
              <svg
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                class="feather feather-calendar"
              >
                <rect x="3" y="4" width="18" height="18" rx="2" ry="2" />
                <path d="M16 2v4M8 2v4M3 10h18" />
              </svg>
              Past Blood Sugar Levels
            </div>
          </div>
        </div>
      </div>
      <div class="user-box third-box">
        <div class="activity card" style="--delay: .2s">
          <div class="title">Previous Doses</div>
          <div class="activity-links"></div>
        </div>
      </div>
      <div class="user-box fourth-box">
        <div class="activity card" style="--delay: .2s">
          <div class="title">Previous Blood Sugar Readings</div>

          <div class="activity-links"></div>
        </div>
        <Chart />
        <Carbs />
      </div>
    </div>
  </div>
</template>

<script>
import BloodSugarService from "../services/BloodSugarService";
import Chart from "./Chart.vue";
import Carbs from "./Carbs.vue";
export default {
  components: { Chart, Carbs },
  data() {
    return {
      BloodSugar: [],
    };
  },

  created() {
    BloodSugarService.getUserBloodSugarReadings()
      .then((response) => {
        this.bloodSugarId = response.data;
      })
      .catch((error) => console.error(error));
  },
};
</script>

<style lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500&display=swap");

$font-family: "Inter", sans-serif;
$bg-color: #252954;
$body-color: #9b9ca7;
$main-bg: #0e0e23;
:root {
  --delay: 0s;
}

* {
  outline: none;
  box-sizing: border-box;
}

.hidden {
  display: none !important;
}

html {
  box-sizing: border-box;
  -webkit-font-smoothing: antialiased;
}

img {
  max-width: 100%;
}

body {
  font-family: $font-family;
  background-color: $bg-color;
  color: $body-color;
}

.wrapper {
  background-color: $main-bg;
  display: flex;
  height: 100%;
  overflow: hidden;
  margin: 0 auto;
}

.left-side {
  width: 6rem;
  display: flex;
  flex-direction: column;
  flex-shrink: 0;
  align-items: center;
  padding: 117px 0 40px;
  animation: left 1s var(--delay) both;
  svg {
    width: 24px;
    cursor: pointer;
    & + svg {
      margin-top: 34px;
    }
    &:last-child {
      margin-top: auto;
    }
    &.active,
    &:hover {
      color: #4255d4;
    }
  }
}

@keyframes left {
  0% {
    transform: translateX(-30px);
    opacity: 0;
  }

  100% {
    opacity: 1;
    transform: none;
  }
}

@keyframes top {
  0% {
    transform: translateY(-30px);
    opacity: 0;
  }

  100% {
    opacity: 1;
    transform: none;
  }
}

.main-container {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  padding: 25px;
  overflow: auto;
  padding-left: 0;
}

.header {
  background: rgb(20, 24, 52);
  background: radial-gradient(
    circle,
    rgba(20, 24, 52, 1) 0%,
    rgba(19, 22, 47, 1) 100%
  );
  box-shadow: 0 16px 12px $main-bg;
  width: 100%;
  padding: 0 30px;
  animation: top 1s both;
  display: flex;
  align-items: center;
  border-radius: 6px;
  font-size: 15px;
  white-space: nowrap;
  position: sticky;
  top: 0;
  left: 0;
  z-index: 10;
  &:before {
    content: "";
    width: 100%;
    height: 25px;
    position: absolute;
    top: -25px;
    left: 0;
    background-color: $main-bg;
  }
  &-link {
    color: $body-color;
    text-decoration: none;
    display: flex;
    align-items: center;
    padding: 20px;
    transition: 0.3s;
    border-bottom: 3px solid transparent;
    transition: 0.3s;
    svg {
      width: 20px;
      margin-right: 14px;
    }
    &.active,
    &:hover {
      background: #11132c;
      border-bottom: 3px solid #4255d4;
    }
  }
}

.logo {
  padding: 20px 50px 20px 0;
  font-size: 16px;
  color: #e7e8ea;
  &-det {
    background: #4255d4;
    padding: 8px;
    margin-left: -2px;
    border-radius: 50%;
    font-size: 15px;
  }
}

.user-info {
  margin-left: auto;
  display: flex;
  align-items: center;
  svg {
    width: 20px;
  }
  .profile {
    margin: 0 20px 0 12px;
    width: 18px;
  }
}
.button {
  display: flex;
  align-items: center;
  color: $body-color;
  background: #1a1b3c;
  border: none;
  padding: 2px 12px;
  border-radius: 4px;
  margin-right: 20px;
  svg {
    margin-left: 10px;
    width: 16px;
  }
}

.user-box {
  margin-top: 25px;
  display: flex;
  & + & {
    margin-top: 20px;
    .cards-wrapper {
      margin-left: 0;
      flex-grow: 1;
      max-width: none;
    }
    .today {
      margin-left: 30px;
    }
    .cards-header {
      padding: 20px 30px;
      justify-content: space-between;
    }
  }
  .cards-header,
  .cards-view {
    display: flex;
    align-items: center;
    justify-content: center;
    svg {
      width: 24px;
    }
    .title {
      margin: 0 16px;
      font-size: 15px;
    }
    &-date svg {
      width: 30px;
    }
    .cards-button {
      background: #15193c;
      padding: 10px 16px;
      margin-right: 0;
      svg {
        width: 16px;
        margin: 0 2px 0 0;
      }
    }
    .date-wrapper {
      display: flex;
      align-items: center;
      margin: auto;
      .title {
        margin: 0 16px;
      }
    }
  }
}

.cards-view > svg {
  margin-right: 12px;
}

.today {
  position: relative;
  &:before {
    content: "";
    position: absolute;
    width: 5px;
    height: 5px;
    bottom: -8px;
    right: 50%;
    border-radius: 50%;
  }
}
.card {
  background: rgb(26, 32, 73);
  background: radial-gradient(
    circle,
    rgba(26, 32, 73, 1) 0%,
    rgba(19, 22, 47, 1) 100%
  );
  padding: 40px 30px;
  border-radius: 6px;
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  max-height: 430px;
  width: 100%;
  .title {
    font-size: 16px;
    font-weight: 500;
  }
  .subtitle {
    font-size: 13px;
    line-height: 1.6em;
  }
  & + & {
    margin-left: 20px;
  }
}

.activity {
  max-width: 480px;
  color: whitesmoke;
  .title {
    margin-bottom: 20px;
  }
  &-links {
    display: flex;
    align-items: center;
    margin-top: auto;
    font-size: 15px;
  }
  &-link {
    padding-bottom: 10px;
    position: relative;
    cursor: pointer;
    transition: 0.3s;
    + .activity-link {
      margin-left: 25px;
      &:before {
        content: "";
        position: absolute;
        width: 5px;
        height: 5px;
        top: -2px;
        right: -8px;
        border-radius: 50%;
      }
      &:hover:after {
        content: "";
        position: absolute;
        width: 22px;
        height: 2px;
        background: #4255d4;
        left: 0;
        bottom: 0;
      }
      &:hover {
        color: #bebec4;
        -webkit-text-stroke: 0.3px;
      }
    }
    &.active {
      color: #bebec4;
      font-weight: 500;
      &:before {
        content: "";
        position: absolute;
        width: 22px;
        height: 2px;
        background: #4255d4;
        left: 0;
        bottom: 0;
      }
    }
  }
}

.destination {
  display: flex;
  align-items: center;
  margin-top: auto;
  &-card {
    background: rgb(26, 29, 58);
    background: linear-gradient(
      45deg,
      rgba(26, 29, 58, 1) 0%,
      rgba(33, 39, 82, 1) 100%
    );
    padding: 20px;
    width: 100%;
    border-radius: 6px;
    & + & {
      margin-left: 20px;
      background: rgb(26, 29, 58);
      background: linear-gradient(
        325deg,
        rgba(26, 29, 58, 1) 0%,
        rgba(33, 39, 82, 1) 100%
      );
    }
  }
  &-profile {
    display: flex;
    align-items: center;
    font-size: 14px;
    svg {
      width: 18px;
      flex-shrink: 0;
      margin-right: 8px;
    }
  }
  &-length {
    margin-left: auto;
    display: flex;
    align-items: center;
    font-size: 13px;
  }
  &-points {
    margin-top: 30px;
  }
}

.profile-img {
  width: 46px;
  height: 46px;
  object-fit: cover;
  border-radius: 50%;
  padding: 2px;
  border: 1px solid #bebec4;
  flex-shrink: 0;
}

.point {
  font-size: 14px;
  color: #bebec4;
  font-weight: 500;
}

.sub-point {
  font-size: 13px;
  margin-top: 4px;
}

.discount {
  max-width: 320px;
  width: 100%;
  .title {
    margin-bottom: 30px;
  }
  .subtitle {
    margin-bottom: 8px;
    &-count {
      font-size: 17px;
      color: #17a98a;
      font-weight: 500;
      & + .subtitle {
        margin-top: 20px;
      }
      &.dist {
        color: #e85471;
      }
    }
  }
  &-wrapper {
    display: flex;
  }
  &-chart {
    margin-left: auto;
  }
  &-profile {
    display: flex;
    align-items: center;
    margin-top: 40px;
  }
  &-img {
    width: 48px;
    height: 48px;
    border-radius: 50%;
    object-fit: cover;
    margin: 0 16px 0 12px;
  }
  &-name {
    font-weight: 500;
    font-size: 15px;
  }
  &-type {
    font-size: 13px;
    margin-top: 4px;
  }
}

.circle {
  width: 100px;
  height: 100px;
  border: 3px solid #5b5f78;
  border-radius: 50%;
  position: relative;
}

.pie {
  position: relative;
  width: 120px;
  height: 120px;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%) rotate(-90deg);
  svg circle {
    fill: transparent;
    stroke: #4356d6;
    stroke-width: 14;
    stroke-dasharray: 275;
    stroke-dashoffset: 235;
    animation: pieChart 3.8s linear forwards;
  }
}

@keyframes pieChart {
  100% {
    stroke-dashoffset: 0;
  }
}

.counter {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  color: #3e50c5;
  font-weight: 500;
}

.offer-button {
  background: #4255d4;
  padding: 14px;
  text-align: center;
  justify-content: center;
  margin-top: auto;
  margin-right: 0;
  color: #fff;
  font-size: 13px;
  cursor: pointer;
}

.cards {
  &-header {
    background: #10122b;
    border-radius: 6px 6px 0 0;
    padding: 20px 45px;
    font-size: 14px;
    font-weight: 500;
    color: whitesmoke;
    &-date {
      display: flex;
      align-items: center;
      justify-content: space-between;
      svg {
        color: #4154d1;
        background: #14183c;
        border-radius: 50%;
        padding: 5px;
        width: 30px;
      }
    }
  }
  &-wrapper {
    margin-left: 20px;
    max-width: 305px;
    width: 100%;
  }
  &-hour {
    font-size: 26px;
    .am-pm {
      font-size: 15px;
      font-weight: 500;
    }
  }
  &.card {
    border-radius: 0 0 6px 6px;
    padding: 30px 20px;
    svg {
      width: 24px;
      margin-left: auto;
      color: #818394;
    }
  }
  &-head {
    display: flex;
    align-items: center;
  }
}

.degree {
  margin-top: 10px;
  font-size: 13px;
  display: flex;
  align-items: center;
  color: #818394;
  font-weight: 500;
  svg {
    width: 24px;
    margin-right: 12px;
  }
}

.items {
  display: flex;
  flex-wrap: wrap;
  margin-top: 16px;
  font-size: 13px;
  font-weight: 500;
  &.numbers {
    margin-top: 0;
  }
}

.item {
  flex: 0 1 calc(100% / 7);
  padding: 10px 5px;
  text-align: center;
  &.is-active {
    background: #4255d4;
    border-radius: 50%;
    color: #fff;
  }
  &.disable {
    color: #595b5b;
  }
}

.account {
  width: 100%;
  height: 180px;
  margin-top: auto;
  flex-grow: 0;
  position: relative;
  transition: 0.3s;
  cursor: pointer;
  transition: 0.3s;
  &:hover {
    transform: scale(1.02);
  }
  &:before {
    content: "";
    position: absolute;
    width: 24px;
    height: 24px;
    box-shadow: -15px 0 0 0 #ef8741;
    background: #ef415c;
    top: 20px;
    left: 42px;
    border-radius: 50%;
  }
  &-wrapper {
    max-width: 310px;
    width: 100%;
    display: flex;
    flex-direction: column;
    margin-left: 20px;
    align-items: center;
  }
  &-profile {
    margin: auto;
    position: relative;
    text-align: center;
    position: relative;
    img {
      width: 84px;
      height: 84px;
      border-radius: 50%;
      object-fit: cover;
      object-position: left;
      border: 3px solid #4255d3;
      padding: 5px;
    }
    .blob {
      position: absolute;
      border-radius: 50%;
      animation: fly 5.8s linear infinite alternate;
      &:nth-child(1) {
        width: 14px;
        height: 14px;
        top: 25px;
        left: -20px;
        background: #28327a;
        animation-delay: 0.9s;
      }
      &:nth-child(2) {
        width: 18px;
        height: 18px;
        background: #87344c;
        right: -20px;
        top: -20px;
        animation-delay: 0.2s;
      }
      &:nth-child(3) {
        width: 12px;
        height: 12px;
        background: #13645b;
        right: -35px;
        top: 50%;
        animation-delay: 1.8s;
      }
    }
  }
  &-name {
    margin: 20px 0 10px;
  }
  &-title {
    font-size: 14px;
  }
  &-cash {
    font-size: 22px;
    font-weight: 500;
    margin-bottom: 6px;
    padding-top: 16px;
    position: relative;
    &:before {
      content: "";
      position: absolute;
      width: 5px;
      height: 5px;
      background: $body-color;
      right: 10px;
      border-radius: 50%;
      box-shadow: -10px 0 0 0 $body-color, 10px 0 0 0 $body-color;
      top: 24px;
    }
  }
  &-income {
    font-size: 14px;
  }
  &-iban {
    margin-top: auto;
    font-weight: 500;
  }
}

.time {
  height: 24px;
  padding: 4px 8px;
  border-radius: 4px;
  background-color: #9e5924;
  font-size: 13px;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  color: #fff;
  &.is-wait {
    background: #4255d3;
  }
}

.table .status {
  color: #1aa385;
  display: inline-flex;
  align-items: center;
  svg {
    margin-right: 6px;
    width: 22px;
    height: 22px;
    padding: 3px;
    border-radius: 4px;
    background-color: #142940;
    color: currentColor;
  }
  &.is-red {
    color: #d14b69;
    svg {
      background: #2e2142;
      color: currentcolor;
    }
  }
  &.is-wait {
    color: #3e4ec2;
    position: relative;
    &:before {
      width: 22px;
      height: 22px;
      position: absolute;
      left: 0;
      top: 0;
      content: "";
      background: #1a214d;
      border-radius: 4px;
    }
    svg {
      background-color: transparent;
      color: currentcolor;
      animation: turn 2s linear infinite both;
    }
  }
}
@keyframes turn {
  100% {
    transform: rotate(1turn);
  }
}

.table {
  text-align: left;
  padding: 0;

  th {
    font-size: 14px;
    font-weight: normal;
    padding-bottom: 16px;
    &:nth-child(n + 5) {
      padding: 0 10px 16px;
    }
    &:first-child {
      padding-left: 36px;
    }
  }

  td {
    font-size: 15px;
    vertical-align: middle;
    padding: 8px 0;
    &:last-of-type {
      width: 100px;
    }
    &:nth-child(n + 5) {
      padding: 0 10px;
    }
    &:nth-last-of-type(2) svg {
      width: 16px;
    }
  }
  input {
    appearance: none;
    width: 16px;
    height: 16px;
    border: 1px solid $body-color;
    vertical-align: middle;
    background-color: transparent;
    border-radius: 4px;
    cursor: pointer;
    margin-right: 16px;
    transition: 0.25s;
    background-size: 0;
    background-position: center;
    &:checked {
      background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' width='24' height='24' stroke='%23fff' stroke-width='2' fill='none' stroke-linecap='round' stroke-linejoin='round' class='css-i6dzq1'%3E%3Cpolyline points='20 6 9 17 4 12'%3E%3C/polyline%3E%3C/svg%3E");
      background-color: $bg-color;
      background-size: 12px;
      background-repeat: no-repeat;
    }
  }
}

@keyframes fly {
  40% {
    transform: translate(-6px, -6px);
  }
  60% {
    transform: translate(-12px, -2px);
  }
  100% {
    transform: translate(0px, 0px);
  }
}

.transection {
  flex-shrink: 0;
  max-width: 310px;
  width: 100%;
  margin-left: 20px;
  &-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    font-weight: 500;
  }
  .is-wait {
    color: #3e4ec2;
  }
}

.credit {
  &-wrapper {
    margin-top: auto;
    display: flex;
    align-items: center;
    font-size: 14px;
    font-weight: 500;
    svg {
      width: 38px;
      padding: 3px;
      border-radius: 6px;
      margin-right: 12px;
    }
    path {
      width: 24px;
    }
  }
  &-money {
    margin-left: auto;
    &.is-active {
      color: #1aa385;
    }
    &.is-cancel {
      color: #d14b69;
    }
    .is-wait {
      color: #3e4ec2;
    }
  }
  &-status {
    font-size: 13px;
    font-weight: normal;
  }
  &-type {
    color: #e7e8ea;
    margin-bottom: 6px;
  }
}

@media screen and (max-width: 1500px) {
  .wrapper {
    max-width: 1200px;
  }
  .activity {
    width: 49%;
    max-width: none;
  }
  .discount {
    width: 48%;
    max-width: none;
    height: 100%;
  }
  .first-box {
    flex-wrap: wrap;
    .cards-wrapper {
      width: 67%;
      max-width: none;
      margin: 20px 0;
      .item.is-active {
        background: none;
        color: inherit;
      }
    }
    .account-wrapper {
      max-width: none;
      width: calc(33% - 20px);
      margin: 20px 0 20px 20px;
    }
  }
  .second-box {
    flex-wrap: wrap;
    .cards-wrapper {
      margin-top: 40px;
      width: 66%;
    }
  }
  .transection {
    margin-top: 40px;
    max-width: none;
    width: 30%;
  }
}

@media screen and (max-width: 1200px) {
  .time {
    display: none;
  }
}

@media screen and (max-width: 1060px) {
  .user-info {
    .button,
    .hour {
      display: none;
    }
  }
}

@media screen and (max-width: 1020px) {
  .user-box .cards-view {
    display: none;
  }
  .user-box .cards-header .cards-button {
    display: none;
  }
  .cards-header-date {
    margin: auto;
  }
}

@media screen and (max-width: 930px) {
  .second-box .cards-wrapper {
    width: 100%;
  }
  .transection {
    width: 100%;
    margin-left: 0;
    height: 100%;
    margin-top: 20px;
  }
  .header-link {
    display: none;
  }
  .user-info .profile {
    margin-right: 0;
  }
}

@media screen and (max-width: 850px) {
  .activity-card,
  .discount {
    width: 100%;
  }
  .user-box .discount {
    margin-left: 0;
    margin-top: 20px;
  }
  .left-side {
    display: none;
  }
  .main-container {
    padding-left: 25px;
  }
  .activity-links,
  .destination {
    margin-top: 20px;
  }
}

@media screen and (max-width: 720px) {
  .first-box .account-wrapper {
    display: none;
  }
  .first-box .cards-wrapper {
    width: 100%;
  }
  .second-box .cards.card {
    overflow-y: auto;
  }
}

@media screen and (max-width: 420px) {
  .destination-card + .destination-card {
    display: none;
  }
}

.user-box > * {
  animation: top 1s var(--delay) both;
}
</style>
