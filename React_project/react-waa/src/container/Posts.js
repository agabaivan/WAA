
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../container/Posts.css'
import PostDetails from '../components/PostDetails';



// const Posts = ({ onPostClick }) => {
//   const [posts, setPosts] = useState([
//     { id: 111, title: 'Happiness', author: 'John' },
//     { id: 112, title: 'MIU', author: 'Dean' },
//     { id: 155, title: 'Enjoy Life', author: 'Jasmine' },
//   ]);

const Posts = ({ onPostClick }) => {
  const [posts, setPosts] = useState([]);
  const [selectedPostId, setSelectedPostId] = useState(null);  
  const [newTitle, setNewTitle] = useState('');  

  useEffect(() => {
  
    const dummyPosts = [
      { id: 1, title: 'Dummy Post 1', author: 'John Doe' },
      { id: 2, title: 'Dummy Post 2', author: 'Jane Doe' },
      { id: 3, title: 'Dummy Post 3', author: 'Alice Smith' },
    ];

    setPosts(dummyPosts);
  }, []);
  
  
  
  
  useEffect(() => {
  
    axios.get(`http://localhost:8080/api/v1/posts`)
        .then(response => setPosts(response.data))
        .catch(error => console.error(`Error fetching details for post :`, error));
  }
  , []);


  const handleNameChange = () => {
    const updatedPosts = [...posts];
    updatedPosts[0].title = newTitle;
    setPosts(updatedPosts);
    setNewTitle('');
  };
  
  const handlePostClick = (postId) => {
    setSelectedPostId(postId);
    onPostClick(postId);
  };


  return (
    <div>
      {/* Display all posts */}
      <div className="posts-container">
        {posts.map((post) => (
          <div key={post.id} className={`post ${selectedPostId === post.id ? 'selected' : ''}`} onClick={() => handlePostClick(post.id)}>
            <p>{post.title}</p>
            <p>{post.author}</p>
          </div>
        ))}
      </div>

      

      <div>
        <input
          type="text"
          value={newTitle}
          onChange={(e) => setNewTitle(e.target.value)}
        />
        <button onClick={handleNameChange}>Change Name</button>
      </div>
    </div>
  );
};
export default Posts;

      
















