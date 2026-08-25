<template>
  <div class="signup">
    <h1>Sign Up</h1>
    <form @submit.prevent="handleSubmit">
      <div>
        <label for="email">Email</label>
        <input id="email" v-model="email" type="email" required />
      </div>
      <div>
        <label for="password">Password</label>
        <input id="password" v-model="password" type="password" required />
      </div>
      <div>
        <label for="confirm">Confirm Password</label>
        <input id="confirm" v-model="confirm" type="password" required />
      </div>
      <button type="submit" :disabled="loading">
        {{ loading ? '...' : 'Sign Up' }}
      </button>
    </form>
    <p v-if="message">{{ message }}</p>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue' 

const email = ref('')
const password = ref('')
const confirm = ref('')
const message = ref('')
const loading = ref(false)

async function handleSubmit() {
  
  message.value = ''
  if (password.value !== confirm.value) {
    message.value = 'Passwords do not match'
    return
  }

  loading.value = true

  try {
    const res = await fetch('/api/signup', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email: email.value, password: password.value }),
    })
    if (!res.ok) throw new Error('Signup failed')
    const data = await res.json()
    message.value = `Signed up successfully`
    email.value = ''
    password.value = ''
    confirm.value = ''
  } catch (err) {
    message.value = 'Signup failed'
    console.error(err)
  } finally {
    loading.value = false
  }
}
</script>
