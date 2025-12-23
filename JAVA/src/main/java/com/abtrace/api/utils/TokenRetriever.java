package com.abtrace.api.utils;

public class TokenRetriever {
    // Token manual
    private static final String accessToken = "eyJraWQiOiJpTklqK1RsM0R6cWE4bG9Ob1V4TEIzTWZ4TlRmcVJjUHM1RmNkcm9LWktBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI5NjAyMzIwNC01MDgxLTcwZmYtZTE3Ny04YWY3NGE0YmFjZTAiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmV1LXdlc3QtMi5hbWF6b25hd3MuY29tXC9ldS13ZXN0LTJfUGx0UXNrdmRnIiwiY29nbml0bzp1c2VybmFtZSI6ImZsYXZpb3Rlc3RlIiwib3JpZ2luX2p0aSI6IjUzZjgwNGYyLTdiZmQtNGQzMS1hNzI1LWZiY2Y3YTAwZTJhMSIsImF1ZCI6InZzczBsNDNmbWViaTJtMzMxYzhxb2ZyOWEiLCJldmVudF9pZCI6IjU2NGU2YjA1LWNlY2QtNDhmYS1hZGRkLTJiZWM4ZjIwNjA0NSIsInRva2VuX3VzZSI6ImlkIiwiYXV0aF90aW1lIjoxNzY2NTEwODA0LCJleHAiOjE3NjY1MTQ0MDQsImlhdCI6MTc2NjUxMDgwNCwianRpIjoiOGEyYTUxNjYtYzMxMi00NWUyLWI2NmUtMGU5YzQ0MmM0NWIxIiwiZW1haWwiOiJuZXlvZmVnNjQxQG5jdGltZS5jb20ifQ.xQCC4l3TXqP_15KYARdtdQW_wDe6GsuFXJ4lsxZJNiyMbWLoPAN5kysCN41rdJYsmhzWh7I9gQWd_2nEKIr0XkVQ665D4V7N3RZzfsxm07WlQx4utH7fmeaXA67qub3kVKUnHUHdUBQVcEmiUTpHI2sq_xwXP0naFSJzIbJ2F1E2EHLOanf67B7jshRyTMUekoxsIlhWBAj3W-t0ndGmcqMruz1J3mnQdpUy1v-fkhwnsQ-yo7ahXCKPqQsdoJohRWGYq-cUGV9ATFkTq3co52X5piOaoeUJxNAierIKjIUGASkvRTc-HkYx19TUeUmrF7FXaYWildNo4o0WHsaPQA";

    // Retorna token
    public static String getToken() {
        if (accessToken == null) {
            throw new IllegalStateException("Token não definido! Use setToken() primeiro.");
        }
        return accessToken;
    }
}
