package com.ali.madarsofttask.presentation.showUserFragment

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.ali.madarsofttask.R
import com.ali.madarsofttask.common.searchQuery
import com.ali.madarsofttask.common.showDialog
import com.ali.madarsofttask.entity.source.model.User
import com.ali.madarsofttask.presentation.UserViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_show_users.*


@AndroidEntryPoint
class ShowUsersFragment : Fragment(R.layout.fragment_show_users), UserAdapter.Interaction,
    SearchView.OnQueryTextListener {
    private val viewModel: UserViewModel by viewModels()
    private val usersAdapter by lazy { UserAdapter(this) }
    private lateinit var searchList: MutableList<User>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchList = mutableListOf()
        setHasOptionsMenu(true)
        setupRecyclerView()
        observeToUsersLiveData()
        swipeToDelete(view)


    }

    private fun swipeToDelete(view: View) {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            override fun onMove(recyclerView: RecyclerView, iewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val user = usersAdapter.differ.currentList[position]
                viewModel.deleteUser(user = user)

                Snackbar.make(view, getString(R.string.deleteArticle), Snackbar.LENGTH_LONG).apply {
                    setAction(getString(R.string.undo)) {
                        viewModel.saveUser(user)
                    }
                    show()
                }
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(userRecycleView)
        }
    }

    private fun observeToUsersLiveData() {
        viewModel.getSavedUsers()?.observe(viewLifecycleOwner, Observer { articles ->
            if (articles != null) {
                usersAdapter.differ.submitList(articles.reversed())
                searchList.addAll(articles)
            }
        })


    }

    private fun setupRecyclerView() {
        userRecycleView.apply {
            adapter = usersAdapter
        }
    }

    override fun onItemSelected(position: Int, item: User) {
        Log.e("ddd","dd")
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_deleteAll -> {

                if (searchList.isNotEmpty())
                    showDialog(getString(R.string.deleteAll), getString(R.string.yes)
                        , DialogInterface.OnClickListener { dialog, which ->
                            viewModel.deleteAllUsers()
                            searchList.clear()
                        }, getString(R.string.no), DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()
                        }, true
                    )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        val menuItem = menu.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        onQueryTextChange(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        usersAdapter.differ.submitList(newText?.searchQuery(searchList))
        return true
    }

}


