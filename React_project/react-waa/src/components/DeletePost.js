import axios from 'axios';
import React from 'react'


const DeletePost = ({ postId, onDelete, onClose }) => {
    const handleDelete = () => {
        if (postId) {
            axios.delete(`https://example.com/api/posts/${postId}`)
                .then(() => {
                    console.log(`Post ${postId} deleted`);
                    onDelete();
                    onClose();
                })
                .catch(error => console.error(`Error deleting post ${postId}:`, error));
        }
    };

    return (
        <div>
            <p>Are you sure you want to delete this post?</p>
            <button onClick={handleDelete}>Yes, Delete</button>
            <button onClick={onClose}>Cancel</button>
        </div>
    );
};

export default DeletePost;

