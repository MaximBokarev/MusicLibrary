package name.max.musiclibrary.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.max.musiclibrary.dao.DBTrackDAO;
import name.max.musiclibrary.dao.PlaylistDAO;
import name.max.musiclibrary.entities.PlayList;
import name.max.musiclibrary.entities.Track;
import name.max.musiclibrary.services.DefaultPlaylistService;
import name.max.musiclibrary.services.DefaultTrackService;

@SuppressWarnings("serial")
public class PlaylistController extends HttpServlet{
	
	private PlaylistDAO pld;
	private DBTrackDAO trd;
	
	DefaultPlaylistService defaultPlaylistService = new DefaultPlaylistService(pld, trd);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] pathInfo = req.getPathInfo() != null ? req.getPathInfo().split("/") : new String[0];

		if (pathInfo.length > 1) {
			long id = 0;

			try {
				id = Long.valueOf(pathInfo[1]);
			} catch (NumberFormatException e) {
				req.setAttribute("msg", "Wrong plalist id format. Must contain only numbers");
				super.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
			}

			PlayList playlist = defaultPlaylistService.getByID(id);
				if (playlist != null) {
					req.setAttribute("playlist", playlist);
					super.getServletContext().getRequestDispatcher("/playlist-details.jsp").forward(req, resp);
				} else

			req.setAttribute("msg", "Playlist with id " + id + " not found");
			super.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
		
		} else {
			try {
				PlayList playlist = defaultPlaylistService.getByID(0);
				req.setAttribute("playlist", playlist);
				super.getServletContext().getRequestDispatcher("/playlist.jsp").forward(req, resp);
			} catch (RuntimeException e) {
				req.setAttribute("msg", e.getMessage());
				super.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}
	}

}
