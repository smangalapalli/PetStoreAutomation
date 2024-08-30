package api.payload;

public class Pet {

	int id;
	Category category;
	String name;
	String [] photoUrls;
	Tag [] tags;
	String status;
	
	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String [] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag [] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }	
    
}
	
	
	/*
	{
		  "id": 0,
		  "category": {
		    "id": 0,
		    "name": "string"
		  },
		  "name": "doggie",
		  "photoUrls": [
		    "string"
		  ],
		  "tags": [
		    {
		      "id": 0,
		      "name": "string"
		    }
		  ],
		  "status": "available"
		}'*/

