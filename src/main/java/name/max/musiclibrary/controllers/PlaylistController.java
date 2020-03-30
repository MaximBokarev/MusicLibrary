package name.max.musiclibrary.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
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
	
	private PlaylistDAO pld = new PlaylistDAO();
	private DBTrackDAO trd = new DBTrackDAO();
	
	DefaultPlaylistService defaultPlaylistService = new DefaultPlaylistService(pld, trd);
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try { 
			List<PlayList> playlists = defaultPlaylistService.getAllPlaylists();
			int a = playlists.size();
			String string = Integer.toString(a);
			super.getServletContext().log(string);
			req.setAttribute("playlists", playlists);
			super.getServletContext().getRequestDispatcher("/playlist.jsp").forward(req, resp);
		}catch (RuntimeException e) {
			req.setAttribute("msg", e.getMessage());
			super.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}

}
