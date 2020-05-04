package com.rocqjones.intoverflown.guesstheword.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.rocqjones.intoverflown.guesstheword.R
import com.rocqjones.intoverflown.guesstheword.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel

    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )

        // Get the viewmodel
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        binding.gameViewModel = viewModel

        // Call binding.setLifecycleOwner to make the data binding lifecycle aware:
        binding.setLifecycleOwner(this)

        /** Setting up LiveData observation relationship **/
//        viewModel.word.observe(this, Observer { newWord ->
//            binding.wordText.text = newWord
//        })

//        viewModel.score.observe(this, Observer { newScore ->
//            binding.scoreText.text = newScore.toString()
//        })

//        viewModel.currentTime.observe(this, Observer { newTime ->
//            binding.timerText.text = DateUtils.formatElapsedTime(newTime)
//
//        })
        // replaced by ' android:text="@{gameViewModel.currentTimeString}"' on XML

        // Sets up event listening to navigate the player when the game is finished
        viewModel.eventGameFinish.observe(this, Observer { isFinished ->
            if (isFinished) {
                val currentScore = viewModel.score.value ?: 0
                val action = GameFragmentDirections.actionGameToScore(currentScore)
                findNavController(this).navigate(action)
                viewModel.onGameFinishComplete()
            }
        })

        return binding.root

    }

}