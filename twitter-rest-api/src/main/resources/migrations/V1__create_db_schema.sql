create schema if not exists bootcamp2306_av;

create table if not exists bootcamp2306_av.users
(
    id bigserial NOT NULL,
    name     varchar(255) NOT NULL,
    age      integer,
    email    varchar(255) NOT NULL,
    password varchar(255) NOT NULL,

    primary key (id)
);


create table if not exists bootcamp2306_av.follow
(
    follow_id bigserial NOT NULL,
    user_follower_id bigint NOT NULL REFERENCES bootcamp2306_av.users(id),
    user_followed_id bigint not null REFERENCES bootcamp2306_av.users(id),
    primary key (follow_id)
);



create table if not exists bootcamp2306_av.tweets
(
    tweet_id bigserial NOT NULL,
    user_id bigint NOT NULL REFERENCES bootcamp2306_av.users (id),
    primary key (tweet_id)
);

create table if not exists bootcamp2306_av.comments
(
    comment_id bigserial NOT NULL,
    comment_text varchar(255) NOT NULL,
    tweet_id     bigint       NOT NULL REFERENCES bootcamp2306_av.tweets (tweet_id),
    user_id      bigint       NOT NULL REFERENCES bootcamp2306_av.users (id),
    primary key (comment_id)
);

create table if not exists bootcamp2306_av.likes
(
    like_id bigserial NOT NULL,
    tweet_id bigint NOT NULL REFERENCES bootcamp2306_av.tweets (tweet_id),
    user_id  bigint NOT NULL REFERENCES bootcamp2306_av.users (id),
    primary key (like_id)
);

create table if not exists bootcamp2306_av.retweets
(
    retweet_id bigserial NOT NULL REFERENCES bootcamp2306_av.users(id),
    tweet_id bigint NOT NULL REFERENCES bootcamp2306_av.tweets (tweet_id),
    user_id  bigint NOT NULL REFERENCES bootcamp2306_av.users (id),
    primary key (retweet_id)
);




