<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <img class="pl-3" alt="Vue logo" src="./assets/ts.png" width="200" height="200">
    <TodoItem class="pt-3" title="Hello" isDone/>
  </div>
</template>

<script>
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import TodoItem from './components/TodoItem.vue'

export default {
  name: 'app',
  components: {
    TodoItem
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
