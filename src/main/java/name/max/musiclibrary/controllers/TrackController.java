package name.max.musiclibrary.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.max.musiclibrary.entities.Track;
import name.max.musiclibrary.services.DefaultTrackService;

@SuppressWarnings("serial")
public class TrackController extends HttpServlet {

	DefaultTrackService defaultTrackService = new DefaultTrackService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] pathInfo = req.getPathInfo() != null ? req.getPathInfo().split("/") : new String[0];

		if (pathInfo.length > 1) {
			long id = 0;

			try {
				id = Long.valueOf(pathInfo[1]);
			} catch (NumberFormatException e) {
				req.setAttribute("msg", "Wrong track id format. Must contain only numbers");
				super.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
			}

			Track track = defaultTrackService.getByID(id);
			if (track != null) {
				String action = String.valueOf(req.getParameter("action"));
				super.log("You call " + action + " action");
				if ("play".equalsIgnoreCase(action)) {
					InputStream is = defaultTrackService.play(track);
					OutputStream os = resp.getOutputStream();

					int b = -1;
					while ((b=is.read()) != -1) {
						os.write(b);
					}
				} else {
					req.setAttribute("track", track);
					super.getServletContext().getRequestDispatcher("/track-details.jsp").forward(req, resp);
				}
			} else {

				req.setAttribute("msg", "Track with id " + id + " not found");
				super.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
			}

		} else {
			try {
				List<Track> tracks = defaultTrackService.getAllTracks();
				req.setAttribute("tracks", tracks);
				super.getServletContext().getRequestDispatcher("/tracks.jsp").forward(req, resp);
			} catch (RuntimeException e) {
				req.setAttribute("msg", e.getMessage());
				super.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}
	}

}
