CREATE TABLE `members` (
                      `member_num`	BIGINT(50)	NOT NULL,
                      `member_id`	VARCHAR(50)	NOT NULL,
                      `member_password`	VARCHAR(255)	NOT NULL,
                      `member_email`	VARCHAR(50)	NOT NULL,
                      `status`	ENUM('Active', 'Inactive', 'Deleted')	NOT NULL
);