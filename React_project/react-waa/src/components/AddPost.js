
import React, { useState } from 'react';
import axios from 'axios';

const AddPost = ({ onPostAdded }) => {
  const [newPost, setNewPost] = useState({
    title: '',
    author: '',
    content: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewPost((prevPost) => ({
      ...prevPost,
      [name]: value,
    }));
  };

  const handleAddPost = () => {
    axios.post('http://localhost:8080/api/v1/posts/', newPost)
      .then((response) => {
        // Assuming the backend responds with the newly added post
        onPostAdded(response.data);
        setNewPost({
          title: '',
          author: '',
          content: '',
        });
      })
      .catch((error) => console.error('Error adding post:', error));
  };

  return (
    <div>
      <h2>Add New Post</h2>
      <div>
        <label>Title:</label>
        <input type="text" name="title" value={newPost.title} onChange={handleInputChange} />
      </div>
      <div>
        <label>Author:</label>
        <input type="text" name="author" value={newPost.author} onChange={handleInputChange} />
      </div>
      <div>
        <label>Content:</label>
        <textarea name="content" value={newPost.content} onChange={handleInputChange} />
      </div>
      <button onClick={handleAddPost}>Add Post</button>
    </div>
  );
};

export default AddPost;
