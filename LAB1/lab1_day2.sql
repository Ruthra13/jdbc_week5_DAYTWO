
1.CREATE TABLE CITY
(
ID NUMBER(11),
NAME VARCHAR(50) NOT NULL,
CONSTRAINT SKILL_PK PRIMARY KEY(ID)
);

2.CREATE TABLE REFEREE
(
ID NUMBER(11),
NAME VARCHAR(50) NOT NULL,
CONSTRAINT REFEREE_PK PRIMARY KEY(ID)
);

3.CREATE TABLE INNINGS
(
ID NUMBER(11),
NAME VARCHAR(50) NOT NULL,
CONSTRAINT INNINGS_PK PRIMARY KEY(ID)
)

4.CREATE TABLE EXTRA_TYPE
(
ID NUMBER(11),
NAME VARCHAR(50) NOT NULL,
CONSTRAINT SKILL_PK PRIMARY KEY(ID)
)

5.CREATE TABLE SKILL
(
ID NUMBER(11),
NAME VARCHAR(50) NOT NULL,
CONSTRAINT SKILL_PK PRIMARY KEY(ID)
);

6.CREATE TABLE TEAM
(
ID NUMBER(11),
NAME VARCHAR(50) NOT NULL,
COACH VARCHAR(50)NOT NULL,
HOME_CITY NUMBER(11) NOT NULL,
CAPTAIN NUMBER(11)NOT NULL,
CONSTRAINT TEAM_PK PRIMARY KEY(ID),
FOREIGN KEY(HOME_CITY) REFERENCES CITY(ID) 
);

7.CREATE TABLE PLAYER
(
ID NUMBER(11),
NAME VARCHAR(50) NOT NULL,
COUNTRY VARCHAR(50) NOT NULL,
SKILL_ID NUMBER(11) NOT NULL,
TEAM_ID NUMBER(11) NOT NULL,
CONSTRAINT PLAYER_PK PRIMARY KEY(ID),
FOREIGN KEY(SKILL_ID) REFERENCES SKILL(ID),
FOREIGN KEY(TEAM_ID) REFERENCES TEAM(ID)
);


8.CREATE TABLE VENUE
(
ID NUMBER(11),
STADIUM_NAME VARCHAR(50)NOT NULL,
CITY_ID NUMBER(11) NOT NULL,
CONSTRAINT VENUE_PK PRIMARY KEY(ID),
FOREIGN KEY(CITY_ID) REFERENCES CITY(ID)
);

 9.CREATE TABLE EVENT
(
ID NUMBER(11),
INNINGS_ID NUMBER(11) NOT NULL,
EVENT_NO NUMBER(11) NOT NULL,
RAIDER_ID NUMBER(11) NOT NULL,
RAID_POINTS NUMBER(11) NOT NULL,
DEFINDING_POINTS NUMBER(11) NOT NULL,
CLOCK_IN_SECONDS NUMBER(11) NOT NULL,
TEAM_ONE_SCORE NUMBER(11) NOT NULL,
TEAM_TWO_SCORE NUMBER(11) NOT NULL,
CONSTRAINT EVENT_PK PRIMARY KEY(ID),
FOREIGN KEY (INNINGS_ID) REFERENCES INNINGS(ID),
FOREIGN KEY (RAIDER_ID) REFERENCES PLAYER(ID)
);

10.CREATE TABLE EXTRA_EVENT
(
ID NUMBER(11),
EVENT_ID NUMBER(11) NOT NULL,
EXTRA_TYPE_ID NUMBER(11) NOT NULL,
POINTS NUMBER(11) NOT NULL,
SCORING_TEAM_ID NUMBER(11) NOT NULL,
FOREIGN KEY (EVENT_ID) REFERENCES EVENT(ID),
FOREIGN KEY (EXTRA_TYPE_ID) REFERENCES EXTRA_TYPE(ID),
FOREIGN KEY (SCORING_TEAM_ID) REFERENCES TEAM(ID)
);

11. CREATE TABLE OUTCOME
(
ID NUMBER(11),
STATUS VARCHAR(100) NOT NULL,
WINNER_TEAM_ID NUMBER(11),
SCORE NUMBER(11),
PLAYER_OF_MATCH NUMBER(11),
CONSTRAINT OUTCOME_PK PRIMARY KEY (ID),
FOREIGN KEY (WINNER_TEAM_ID) REFERENCES TEAM(ID),
FOREIGN KEY (PLAYER_OF_MATCH) REFERENCES PLAYER(ID)
);

12. CREATE TABLE GAME
(
ID NUMBER(11),
GAME_DATE DATE,
TEAM_ID_1 NUMBER(11) NOT NULL,
TEAM_ID_2 NUMBER(11)NOT NULL,
VENUE_ID NUMBER(11) NOT NULL,
OUTCOME_ID NUMBER(11) NOT NULL,
REFEREE_ID_1 NUMBER(11) NOT NULL,
REFEREE_ID_2 NUMBER(11) NOT NULL,
FIRST_INNINGS_ID NUMBER(11) NOT NULL,
SECOND_INNINGS_ID NUMBER(11) NOT NULL,
CONSTRAINT GAME_PK PRIMARY KEY (ID),
FOREIGN KEY (TEAM_ID_1) REFERENCES TEAM(ID),
FOREIGN KEY (TEAM_ID_2) REFERENCES TEAM(ID),
FOREIGN KEY (VENUE_ID) REFERENCES VENUE(ID),
FOREIGN KEY (OUTCOME_ID) REFERENCES OUTCOME(ID),
FOREIGN KEY (REFEREE_ID_1) REFERENCES REFEREE(ID),
FOREIGN KEY (REFEREE_ID_2) REFERENCES REFEREE(ID),
FOREIGN KEY (FIRST_INNINGS_ID) REFERENCES INNINGS(ID),
FOREIGN KEY (SECOND_INNINGS_ID) REFERENCES INNINGS(ID)
);








