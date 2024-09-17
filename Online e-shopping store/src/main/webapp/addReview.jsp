<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="addReview" method="POST">
        <div class="form-group">
            <label for="rating">Rate (1 to 5):</label><br><br>
            <select name="rating" required>
                <option value="" disabled selected>Select a rating</option>
                <option value="1">1 - Very Poor</option>
                <option value="2">2 - Poor</option>
                <option value="3">3 - Average</option>
                <option value="4">4 - Good</option>
                <option value="5">5 - Excellent</option>
            </select>
        </div>
        
        <div class="form-group">
            <label for="review">Your Review:</label><br><br>
            <textarea name="review" rows = "10" cols = "50" placeholder="Write your review here..." required></textarea>
        </div>
        
        <input type="submit" name = "submit" value = "Submit Review">
    </form>
	
</body>
</html>