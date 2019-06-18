<template>
  <div class="todo">
    <div class="input-group col-12">
      <input type="text" class="form-control" aria-label="What needs to be done?" v-model="newTodo">

      <div class="input-group-append">
        <button
          class="btn btn-outline-secondary"
          type="button"
          id="button-addon2"
          v-on:click="addTodo"
        >Add</button>
      </div>
    </div>
    <div class="col-12">
      <TodoItem
        v-bind:key="todo.id"
        v-bind:id="todo.id"
        v-bind:title="todo.title"
        v-bind:isDone="todo.isDone"
        v-on:statusChanged="toggleTodo"
        v-on:onDeleteClicked="deleteTodo"
        v-for="todo in todos"
      />
    </div>
  </div>
</template>

<script>
import TodoItem from "./TodoItem";

export default {
  name: "TodoList",
  data() {
    return {
      todos: Array,
      newTodo: ""
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.todos = [
        {
          id: 1,
          title: "Aprender Javascript",
          isDone: true
        },
        {
          id: 2,
          title: "Aprender Vue",
          idDone: false
        },
        {
          id: 3,
          title: "Fazer um front bonito",
          isDone: false
        }
      ];
    },
    addTodo() {
      const newTitle = this.newTodo && this.newTodo.trim();
      if (!newTitle) {
        return;
      }

      const lastId = this.todos.length;

      const newTodoObject = {
        id: lastId + 1,
        title: newTitle,
        idDone: false
      };

      this.todos = [newTodoObject, ...this.todos];

      this.newTodo = "";
    },
    toggleTodo(id) {
      this.todos = this.todos.map(todo => {
        if (todo.id === id) {
          todo.isDone = !todo.isDone;
        }

        return todo;
      });
    },
    deleteTodo(id) {
      this.todos = this.todos.filter(todo => {
        if (todo.id !== id) {
          return todo;
        }
      });
    }
  },
  components: {
    TodoItem
  }
};
</script>
