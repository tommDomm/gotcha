import domain.Artist;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@WebServlet(name = "vote", urlPatterns = "/vote_result")
public class VoteServletExt extends HttpServlet {

    private float percent;
    int artist_count = 0;
    int eminemArtistCount = 0;
    int ImagineDragonsArtistCount = 0;
    int TimmyTrumpetArtistCount = 0;
    int GodModeArtistCount = 0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType(StandardCharsets.UTF_8.name());
        PrintWriter printWriter = resp.getWriter();
        resp.addDateHeader("dfw", Long.parseLong("123"));

        switch (req.getParameter("music_player")) {
            case "Eminem" -> {
                artist_count++;
                eminemArtistCount++;
            }
            case "ImagineDragons" -> {
                artist_count++;
                ImagineDragonsArtistCount++;
            }
            case "TimmyTrumpet" -> {
                artist_count++;
                TimmyTrumpetArtistCount++;
            }
            case "GodeMode" -> {
                artist_count++;
                GodModeArtistCount++;
            }

            default -> throw new IllegalStateException("Unexpected value: " + req.getParameter("music_player"));
        }


        req.getParameterMap().forEach((key, value) -> printWriter.write(key + ":" + Arrays.toString(value)));


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType(StandardCharsets.UTF_8.name());
        PrintWriter printWriter = resp.getWriter();

        req.getParameterMap().forEach((key, value) -> printWriter.write(key + ":" + Arrays.toString(value)));


    }

    private float getTopArtist(int countReq, int Em, int ID, int TT, int GM) {

        int max = Em;

        if (ID > max)
            max = ID;
        if (TT > max)
            max = TT;
        if (GM > max)
            max = GM;
        return max;
    }
}