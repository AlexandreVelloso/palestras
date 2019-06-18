<template>
  <div class="item">
    <div class="card col-md-12">
      <div class="card-body">
        <h5 class="card-title">{{ title }}</h5>

        <div class="btn-group" role="group">
          <a
            v-bind:class="{ 'btn btn-success': isDone , 'btn btn-warning': !isDone }"
            v-on:click="toggleButton"
            href="#"
          >
            <div v-if="isDone">Done</div>
            <div v-if="!isDone">Not finished</div>
          </a>

          <a v-on:click="deleteTodo" class="btn btn-danger" href="#">Delete</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "TodoItem",
  props: {
    id: Number,
    title: String,
    isDone: Boolean
  },
  methods: {
    toggleButton() {
      this.$emit("statusChanged", this.id);
    },
    deleteTodo() {
      this.$emit("onDeleteClicked", this.id);
    }
  }
};
</script>
