<template>
    <div class="item">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title"> {{ title }} </h5>
          
          <a v-if="!isDone" href="#" class="btn btn-danger">Not finished</a>
          <a v-if="isDone" href="#" class="btn btn-success">Done</a>

        </div>
      </div>
    </div>
</template>

<script>
export default {
  name: 'TodoItem',
  props: {
    id: Number,
    title: String,
    isDone: Boolean
  }
}
</script>
