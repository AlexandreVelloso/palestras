<template>
    <div class="item">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title"> {{ title }} </h5>
          
          <a v-bind:class="{ 'btn btn-success': isDone , 'btn btn-danger': !isDone }" href="#">
            <div v-if="isDone">Done</div>
            <div v-if="!isDone">Not finished</div>
          </a>

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
