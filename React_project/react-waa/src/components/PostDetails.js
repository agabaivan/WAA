
import React, { useEffect, useState } from 'react';
import '../container/PostDetails.css'
import axios from 'axios';
import DeletePost from './DeletePost';
import Comment from './Comment';

const PostDetails = ({ postId, onDelete }) => {
    const [postDetails, setPostDetails] = useState({
        id: postId,
        title: '',
        author: '',
        content: '',
    });
    const [comments, setComments] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:8080/api/v1/posts/${postId}`)
            .then(response => setPostDetails(response.data))
            .catch(error => console.error('Error getting post details', error));
        setPostDetails((prevDetails) => ({
            ...prevDetails,
            title: `Dummy Post Title ${postId}`,
            author: `Dummy Author ${postId}`,
        }));
    }, [postId]);

    useEffect(() => {
        const fetchComments = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/v1/posts/${postId}/comments`);
                setComments(response.data);
            } catch (error) {
                console.error('Error getting comments', error);
            }
        };

        fetchComments();
    }, [postId]);

    return (
        <div className="post-details-box">
            <h2>{postDetails.title}</h2>
            <p>Author: {postDetails.author}</p>
            <p>{postDetails.content}</p>
            <DeletePost postId={postId} onDelete={onDelete} />
            <h3>Comments</h3>
            {comments.map(comment => (
                <Comment key={comment.id} comment={comment} />
            ))}
        </div>
    );
}

export default PostDetails;

