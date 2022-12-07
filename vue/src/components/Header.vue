<template>
  <div>
    <header id="header" class="header">
    <img src="../assets/insulin_hero-removebg-preview.png" class="logo" alt="Insulin Hero" id="header-img" />
    <nav id="nav-bar" class="nav">
      <ul class="nav-list">
        <li class="nav-item">
          <a class="nav-link" href="#features">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#how-it-works">How It Works</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#get-started">Get Started</a>
        </li>
        <li class="nav-item">
           <router-link class="nav-link nav-link-cta" v-bind:to="{ name:'login' }">Login</router-link>
        </li>
      </ul>
    </nav>
    <button class="nav-toggle" aria-label="Toggle navigation" aria-expanded="false">
      <span class="visuallyhidden">Menu</span>
      <span class="hamburger"></span>
    </button>
  </header>
  </div>
</template>
  
<script>
export default {

}
</script>

<style>
.container {
    width: 1170px;
    padding-right: 15px;
    padding-left: 15px;
    margin: auto;
}
.container {
    position: relative;
    background-color: #FFF;
}

.container .header-area {
    display: flex;
    padding: 25px 0 0;
    position: relative;
}

.container .header-area .logo {
    text-transform: uppercase;
    font-style: italic;
    margin-top: 10px;
    font-size: 19px;
    width: 300px;
    color: #5d5d5d;
}

.container .header-area .links {
    list-style: none;
    padding: 0;
    margin: 0;
    width: 100%;
    text-align: right;
}

.container .header-area .links li {
    display: inline-block;
    margin-left: 30px;
    color: #5d5d5d;
    cursor: pointer;
}

.container .header-area .links li:last-child {
    border: 0;
    border-radius: 20px;
    padding: 10px 18px;
    color: #FFF;
    background-color: #6c63ff;
}
.header > img {
  max-width: 100px;
  scale: 150%;
  margin-left: 20px;
}
</style>