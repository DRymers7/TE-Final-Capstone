<template>
  <div id="app">
    <div id="nav">

      <header>Insulin Hero </header>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <nav></nav>  

    </div>
    <router-view />
  </div>
</template>


<style scoped>
header{
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 100px;
  color: #173054;
  margin-top: 25px;
}



body {
  margin:0;
  padding:0;
  font-family: open sans, Arial, Helvetica, sans-serif;
  color: whitesmoke

}


app{
  background-color: #dbe9eeff;
  font-family: open sans, Arial, Helvetica, sans-serif;
}

</style>





--cadet: #4f6d7aff;
--columbia-blue: #c0d6dfff;
--alice-blue: #dbe9eeff;
--blue-yonder: #4a6fa5ff;
--blue-sapphire: #166088ff;

