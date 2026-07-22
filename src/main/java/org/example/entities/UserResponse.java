package org.example.entities;

import lombok.Data;

@Data
public class UserResponse {

    private UserData data;

    @Data
    public static class UserData {
        private String id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        public UserData setId(String id) {
            this.id = id;
            return this;
        }
        public UserData setEmail(String email) {
            this.email = email;
            return this;
        }
        public UserData setFirst_name(String first_name) {
            this.first_name = first_name;
            return this;
        }
        public UserData setLast_name(String last_name) {
            this.last_name = last_name;
            return this;
        }
        public UserData setAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }
    }
}
